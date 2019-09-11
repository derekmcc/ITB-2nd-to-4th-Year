using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[RequireComponent(typeof(Rigidbody2D))]
public class ThrowKnife : MonoBehaviour
{

    public float speed;

    private Rigidbody2D myRigidBody;
    private Vector2 direction;

    // Use this for initialization
    void Start() {
        myRigidBody = GetComponent<Rigidbody2D>();
    }

    void FixedUpdate() {
        myRigidBody.GetComponent<Rigidbody2D>().velocity = direction * speed;
    }

    public void KnifeDirection(Vector2 direction) {
        this.direction = direction;
    }

    void OnBecameInvisible() {
        Destroy(gameObject);
    }

    void OnTriggerEnter2D(Collider2D other) {
        if (other.gameObject.tag == "CantThrowThrough") {
            Destroy(gameObject);
        }
    }
}