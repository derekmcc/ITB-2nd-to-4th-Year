using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CollisionTrigger : MonoBehaviour {

	public BoxCollider2D platformCollider;
	public BoxCollider2D trigger;

	// Use this for initialization
	void Start () {	
		Physics2D.IgnoreCollision (platformCollider, trigger, true);
	}
	
	void OnTriggerEnter2D(Collider2D other){
		if (other.gameObject.name == "Character" || other.gameObject.tag == "Enemy") {
			Physics2D.IgnoreCollision (platformCollider, other,true);
		}
	}

	void OnTriggerExit2D(Collider2D other){
		if (other.gameObject.name == "Character" || other.gameObject.tag == "Enemy") {
			Physics2D.IgnoreCollision (platformCollider, other,false);
		}
	}
}
