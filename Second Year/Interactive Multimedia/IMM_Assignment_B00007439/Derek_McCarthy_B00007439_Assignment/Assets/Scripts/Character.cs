using System.Collections;
using UnityEngine;
using UnityEngine.SceneManagement;

public delegate void DeadEventHandler();

public class Character : Person {

	private static Character instance;
    public event DeadEventHandler dead;
    public AudioClip coinSound;
    public AudioClip hurtSound;
    public AudioClip dyingSound;
    public AudioClip healthSound;
    private AudioSource audioSource;
    [SerializeField]
	private float groundRadius;
    private static int lives = 3;
	[SerializeField]
	private Transform[] groundPoints;
    [SerializeField]
    private GameObject shieldGO;
    
    public bool inAir;
    private bool immortal = false;

    [SerializeField]
    private float immortalTime;
    private IUseable useable;
	public float jumpForce = 1000f;
    public float climbSpeed;
	public LayerMask whatIsGround;
    public Vector2 startPos;
    private SpriteRenderer spriteRenderer;
    private float deathY = -9;
    private static int score = 0;
    public LevelManager levelManager;

    public bool OnLadder {
        get;
        set;
    }

    public static Character Instance{
		get { 
			if (instance == null) {
				instance = GameObject.FindObjectOfType<Character> ();
			}
			return instance;
		}
	}

	public Rigidbody2D myRigidBody{
		get;
		set;
	}
		
	public bool slide{
		get;
		set;
	}

	public bool jump{
		get;
		set;
	}

	public bool isGrounded{
		get;
		set;
	}

	// Use this for initialization
	public override void Start () {
        base.Start ();
        OnLadder = false;
        levelManager = FindObjectOfType<LevelManager>();
        spriteRenderer = GetComponent<SpriteRenderer>();
		myRigidBody = GetComponent<Rigidbody2D> ();
        audioSource = GetComponent<AudioSource>();
        PlayerDisplay.Instance.UpdateLivesImage(lives);
        PlayerDisplay.Instance.UpdateScoreText();
    }

	void Update() {
        if (!TakingDamage && !IsDead) {
            if (transform.position.y <= -14f) {
                Death();
            }
        }
        shieldGO.SetActive(immortal);
        UserInput ();
        CheckGameWOn();
        PlayerDisplay.Instance.UpdateLivesImage(lives);
        PlayerDisplay.Instance.UpdateScoreText();
    }
		
	void FixedUpdate () {
        if (!TakingDamage && !IsDead) {
            float horizontal = Input.GetAxis ("Horizontal");
            float vertical = Input.GetAxis("Vertical");
            isGrounded = IsGrounded ();
		    CharacterMovement (horizontal, vertical);
		    Flip (horizontal);
		    ManageLayers ();
        }
	}

    public void OnDead() {
        if(dead != null) {
            dead();
        }                    
    }
	private void CharacterMovement(float horizontal, float vertical) {
		if(myRigidBody.GetComponent<Rigidbody2D> ().velocity.y < 0) {
			MyAnimator.SetBool ("Landing",true);
		}
		if (!attack && !slide && (isGrounded || inAir)) {
			myRigidBody.GetComponent<Rigidbody2D>().velocity = new Vector2(horizontal * movementSpeed,GetComponent<Rigidbody2D>().velocity.y);
		}
		if (jump && myRigidBody.GetComponent<Rigidbody2D>().velocity.y == 0 && !OnLadder) {
			myRigidBody.AddForce (new Vector2 (0, jumpForce));
		}
        if (OnLadder) {
            MyAnimator.speed = vertical != 0 ? Mathf.Abs(vertical) : Mathf.Abs(horizontal);
            myRigidBody.velocity = new Vector2(horizontal * climbSpeed,vertical * climbSpeed);
        }
		MyAnimator.SetFloat ("Speed", Mathf.Abs(horizontal));
	}

	private void Flip(float horizontal){
		if (horizontal > 0 && !facingRight || horizontal < 0 && facingRight) {
			ChangeDirection ();
		}
	}

	private void UserInput(){
		if (Input.GetKeyDown (KeyCode.Space)) {
			MyAnimator.SetTrigger("Attack");
		}
		if (Input.GetKeyDown (KeyCode.DownArrow)) {
			MyAnimator.SetTrigger("Slide");
		}
        if (OnLadder == false) {
            if (Input.GetKeyDown(KeyCode.UpArrow) && !OnLadder) {
                MyAnimator.SetTrigger("Jumping");
            }
        }
		
		if (Input.GetKeyDown(KeyCode.LeftControl)){
			MyAnimator.SetTrigger("Throwing");
		}
        if (Input.GetKeyDown(KeyCode.LeftAlt)) {
            Use();
        }
    }
		
	private bool IsGrounded(){
		if (myRigidBody.GetComponent<Rigidbody2D> ().velocity.y <= 0) {

			foreach(Transform point in groundPoints){

				Collider2D[] colliders = Physics2D.OverlapCircleAll (point.position, groundRadius, whatIsGround);

				for (int i = 0; i < colliders.Length; i++) {
					if(colliders[i].gameObject != gameObject) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private void ManageLayers() {
		if (!isGrounded) {
			MyAnimator.SetLayerWeight (1, 1);
		} else {
			MyAnimator.SetLayerWeight (1,0);
		}
	}

	public override void ThrowKnife(int value) {
		if(!isGrounded && value == 1 || isGrounded && value == 0) {
			base.ThrowKnife (value);
		}
	}

	public override IEnumerator TakeDamage() {
        if (!immortal) {
            healthStat.CurrentVal -= 10;
            if (!IsDead) {
                audioSource.PlayOneShot(hurtSound);
                MyAnimator.SetTrigger("Damage");
                immortal = true;
                StartCoroutine(DisplayImomortal());
                yield return new WaitForSeconds(immortalTime);
                immortal = false;
            }
            else {
                audioSource.PlayOneShot(dyingSound);
                CheckForLives();
                MyAnimator.SetLayerWeight(1, 0);
                MyAnimator.SetTrigger("Die"); 
            }
        }
        yield return null;
    }

	public override bool IsDead {
		get {
            if (healthStat.CurrentVal <= 0) {
                OnDead();
            }
			return healthStat.CurrentVal <= 0;
		}
	}

    private IEnumerator DisplayImomortal() {
        while (immortal) {
            spriteRenderer.enabled = false;
            yield return new WaitForSeconds(.1f);
            spriteRenderer.enabled = true;
            yield return new WaitForSeconds(.1f);
        }
    }

    public override void Death() {
        lives--;
        CheckForLives();
        myRigidBody.velocity = Vector2.zero;
        MyAnimator.SetTrigger("Idle");
        healthStat.CurrentVal = healthStat.MaxVal;
        levelManager.RespawnPlayer();
        PlayerDisplay.Instance.UpdateLivesImage(lives);
    }

    private void OnCollisionEnter2D(Collision2D other){
        if(other.gameObject.tag == "Heart") {
            Destroy(other.gameObject);
            healthStat.CurrentVal += 10;
            audioSource.PlayOneShot(healthSound);
            UImanager.Instance.Score += 5;
        }
    }

    public override void OnTriggerEnter2D(Collider2D other) {
        if (other.tag == "Useable") {
            useable = other.GetComponent<IUseable>();
        }
        if (other.tag == "Coin") {
            UImanager.Instance.CoinsCollected++;
            Destroy(other.gameObject);
            audioSource.PlayOneShot(coinSound);
            UImanager.Instance.Score+=10;
        }
        if (other.tag == "Player") {
            levelManager.RespawnPlayer();
        }
        base.OnTriggerEnter2D(other);
    }

    private void Use() {
        if (useable != null) {
            useable.Use();
        }
    }

    public void OnTriggerExit2D(Collider2D other){
        if (other.tag == "Useable") {
            useable = null;
        }
    }

    private void CheckDeathYReached() {
        float y = transform.position.y;
        if (y < deathY) {
            Death();
        }
    }

    private void CheckForLives() {
        if (lives < 0) {
            audioSource.PlayOneShot(healthSound);
            Reset();
#pragma warning disable CS0618 // Type or member is obsolete
            Application.LoadLevel("scene1_GameOver");
#pragma warning restore CS0618 // Type or member is obsolete
            Reset();
        }
    }

    private int CountNumCoins(string tag) {
        GameObject[] coinObjects = GameObject.FindGameObjectsWithTag(tag);
        return coinObjects.Length; 
    }

    private void CheckGameWOn() {
        int numCoins = CountNumCoins("Coin");
        if (numCoins < 1){
           if((SceneManager.GetActiveScene().buildIndex + 1) < 6) {
                if ((SceneManager.GetActiveScene().buildIndex + 1) == 5){
                    Reset();
                }
                SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex + 1);
            }
            else {
                Reset();
                Application.LoadLevel("scene0_Welcome");
            }
        }
    }

    public void Reset() {
        lives = 3;
        score = 0;
        UImanager.Instance.Score = 0;
        UImanager.Instance.CoinsCollected = 0;
        healthStat.CurrentVal = healthStat.MaxVal;
    }
}
