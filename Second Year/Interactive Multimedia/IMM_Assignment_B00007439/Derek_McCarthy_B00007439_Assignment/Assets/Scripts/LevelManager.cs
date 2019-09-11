using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LevelManager : MonoBehaviour {

    public GameObject currentCheckPoint;
    private Character character;

	// Use this for initialization
	void Start () {
        character = FindObjectOfType<Character>();
	}
	
	// Update is called once per frame
	void Update () {
		
	}

    public void RespawnPlayer() {
        character.transform.position = currentCheckPoint.transform.position;
    }
}
