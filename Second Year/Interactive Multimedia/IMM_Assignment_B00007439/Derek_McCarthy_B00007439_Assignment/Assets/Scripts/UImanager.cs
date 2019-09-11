using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class UImanager : MonoBehaviour {
    private static UImanager instance;
    [SerializeField]
    private GameObject heartPrefab;
    [SerializeField]
    private GameObject coinPrefab;
    public static UImanager Instance {
        get {
            if(instance == null) {
                instance = FindObjectOfType<UImanager>();
            }
            return instance;
        }
    }
    [SerializeField]
    private Text coinText;
    private int coinsCollected;
    private static int score;
    public GameObject HeartPrefab {
        get {
            return heartPrefab;
        }
    }

    public int CoinsCollected {
        get {
            return coinsCollected;
        }

        set {
            coinText.text = value.ToString();
            coinsCollected = value;
        }
    }

    public int Score {
        get {
            return score;
        }

        set {
            score = value;
        }
    }

    // Use this for initialization
    void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
