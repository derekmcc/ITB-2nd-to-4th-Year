using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LadderScript : MonoBehaviour, IUseable {
    [SerializeField]
    private Collider2D platformCollider;
    public void Use() {
        if (Character.Instance.OnLadder) {
            UseLadder(false, 1, 0, 1, "Landing");
        }
        else {
            UseLadder(true, 0, 1, 0, "Reset");
            Physics2D.IgnoreCollision(Character.Instance.GetComponent<Collider2D>(), platformCollider, true);
        }
    }

    private void UseLadder(bool onLadder, int gravity, int layerWeight, int animSpeed, string trigger) {
        Character.Instance.OnLadder = onLadder;
        Character.Instance.myRigidBody.gravityScale = gravity;
        Character.Instance.MyAnimator.SetLayerWeight(2, layerWeight);
        Character.Instance.MyAnimator.speed = animSpeed;
        Character.Instance.MyAnimator.SetTrigger(trigger);
    }

    // Use this for initialization
    void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}

    private void OnTriggerExit2D(Collider2D other) {
        if (other.tag == "Player") {
            UseLadder(false, 1, 0, 1, "Landing");
            Physics2D.IgnoreCollision(Character.Instance.GetComponent<Collider2D>(), platformCollider, false);
        }
    }
}
