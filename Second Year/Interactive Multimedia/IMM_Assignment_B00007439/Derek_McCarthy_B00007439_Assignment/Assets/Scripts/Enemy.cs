using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : Person {
	[SerializeField]
	private float meleeRage;
	[SerializeField]
	private float throwRage;
	private IEnemyState currentState;
    [SerializeField]
    private Transform leftEdge;
    [SerializeField]
    private Transform rightEdge;
    private Canvas healtCanvas;
    //To Respawn Enemy
    private Vector3 startPos;
    //
    public AudioClip hurtSound;
    public AudioClip dyingSound;
    private AudioSource audioSource;
    private bool dropHealth = true;
    public GameObject Target {
		get;
		set;
	}

	public bool InMeleeRange {
		get{
			if (Target != null) {
				return Vector2.Distance (transform.position, Target.transform.position) <= meleeRage;
			}
			return false;
		}
	}

	public bool InThrowRange {
		get{
			if (Target != null) {
				return Vector2.Distance (transform.position, Target.transform.position) <= throwRage;
			}
			return false;
		}
	}

	// Use this for initialization
	public override void Start () {
        //To Respawn enemy
        this.startPos = transform.position;
        //
        audioSource = GetComponent<AudioSource>();
        base.Start ();
        Character.Instance.dead += new DeadEventHandler(RemoveTarget);
		ChangeState (new IdleState ());
        healtCanvas = transform.GetComponentInChildren<Canvas>();
	}
	
	// Update is called once per frame
	void Update () {
        if (!IsDead) {
            if (!TakingDamage) {
                currentState.Execute();
            }
            LookAtTarget();
        }  
	}

	public void ChangeState(IEnemyState newState){
		if (currentState != null) {
			currentState.Exit ();
		}	
		currentState = newState;
		currentState.Enter (this);
	}

	public void Movement(){
		if (!attack) {
            if(GetDirection().x > 0 && transform.position.x < rightEdge.position.x || GetDirection().x < 0 && transform.position.x > leftEdge.position.x)
            {
                MyAnimator.SetFloat("Speed", 1);
                transform.Translate(GetDirection() * (movementSpeed * Time.deltaTime));
            }
            else if (currentState is PatrolState){
                ChangeDirection();
            }
            else if (currentState is RangedState) {
                Target = null;
                ChangeState(new IdleState());
            }
		}
	}

	public Vector2 GetDirection(){
		return facingRight ? Vector2.right : Vector2.left;
	}

	public override void OnTriggerEnter2D(Collider2D other){
		base.OnTriggerEnter2D (other);
		currentState.OnTriggerEnter (other);
	}

	private void LookAtTarget(){
		if (Target != null) {
			float xDir = Target.transform.position.x - transform.position.x;
			if (xDir < 0 && facingRight || xDir > 0 && !facingRight) {
				ChangeDirection ();
			}
		}
	}

	public override IEnumerator TakeDamage() {
        if (!healtCanvas.isActiveAndEnabled) {
            healtCanvas.enabled = true;
        }

        healthStat.CurrentVal -= 10;

		if (!IsDead) {
            audioSource.PlayOneShot(hurtSound);
            MyAnimator.SetTrigger ("Damage");
            UImanager.Instance.Score += 20;
        }
        else {
            if (dropHealth) {
                GameObject heart = (GameObject)Instantiate(UImanager.Instance.HeartPrefab, new Vector3(transform.position.x, transform.position.y + 2), Quaternion.identity);
                Physics2D.IgnoreCollision(heart.GetComponent<Collider2D>(), GetComponent<Collider2D>());
                audioSource.PlayOneShot(dyingSound);
                UImanager.Instance.Score += 40;
                dropHealth = false;
            } 
            MyAnimator.SetTrigger ("Die");
            
            yield return null;
        }
    }

	public override bool IsDead {
		get {
			return healthStat.CurrentVal <= 0;
		}
	}

    public void RemoveTarget() {
        Target = null;
        ChangeState(new PatrolState());
    }

    public override void Death() {   
        MyAnimator.ResetTrigger("Die");
        MyAnimator.SetTrigger("Idle");
        healthStat.CurrentVal = healthStat.MaxVal;
        transform.position = startPos;
        healtCanvas.enabled = false;
        dropHealth = true;
    }

    public override void ChangeDirection() {
        //Makes a reference to the enemys canvas
        Transform temp = transform.FindChild("EnemyCanvas").transform;

        //Stores the position, so that we know where to move it after we have flipped the enemy
        Vector3 pos = temp.position;

        ///Removes the canvas from the enemy, so that the health bar doesn't flip with it
        temp.SetParent(null);

        ///Changes the enemys direction
        base.ChangeDirection();

        //Puts the health bar back on the enemy.
        temp.SetParent(transform);

        //Pits the health bar back in the correct position.
        temp.position = pos;
    }
}
