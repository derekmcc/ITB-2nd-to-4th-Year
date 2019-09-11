using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public abstract class Person : MonoBehaviour {

	[SerializeField]
	protected Transform knifePosition;
	[SerializeField]
	protected float movementSpeed;
	[SerializeField]
	private GameObject knife;
    [SerializeField]
    private EdgeCollider2D swordCollider;
    [SerializeField]
    private List<string> damageSources;
    [SerializeField]
    protected Stat healthStat;
    protected bool facingRight;

	public abstract IEnumerator TakeDamage ();
    public abstract void Death();

    public bool TakingDamage  { get; set; }
    public abstract bool IsDead { 
		get; 
	}

	public Animator MyAnimator {
		get;
		set;
	}
	public bool attack{
		get;
		set;
	}

    public EdgeCollider2D SwordCollider {
        get {
            return swordCollider;
        }
    }

    // Use this for initialization
    public virtual void Start () {
		facingRight = true;
		MyAnimator = GetComponent<Animator> ();
        healthStat.Init();
    }
	
	// Update is called once per frame
	void Update () {
       
	}

	public virtual void ChangeDirection(){
		facingRight = !facingRight;
		transform.localScale = new Vector3 (transform.localScale.x * -1,0.5f,0.5f);
	}

	public virtual void ThrowKnife(int value){
		if (facingRight) {
			GameObject temp = (GameObject)Instantiate (knife, knifePosition.position, Quaternion.Euler(new Vector3(0,0,-90)));
			temp.GetComponent<ThrowKnife> ().KnifeDirection (Vector2.right);
		} else {
			GameObject temp = (GameObject)Instantiate (knife, knifePosition.position, Quaternion.Euler(new Vector3(0,0,90)));
			temp.GetComponent<ThrowKnife> ().KnifeDirection (Vector2.left);
		}
	}
		
	public virtual void OnTriggerEnter2D(Collider2D other){
		if (damageSources.Contains(other.tag)) {
			StartCoroutine (TakeDamage ());
		}
	}

    public void MeleeAttack() {
        SwordCollider.enabled = true;
    }
}
