﻿using UnityEngine;
using System.Collections;

using UnityEngine.UI;

public class PlayerDisplay : MonoBehaviour {
    private static PlayerDisplay instance;
    public Text scoreText;
    public Image livesImage;

    public Sprite lives0Sprite;
    public Sprite lives1Sprite;
    public Sprite lives2Sprite;
    public Sprite lives3Sprite;

    public void UpdateScoreText() {
        int newScore = UImanager.Instance.Score;
        string scoreMessage = "Score: " + newScore;
        scoreText.text = scoreMessage;
    }

    public static PlayerDisplay Instance {
        get {
            if (instance == null)
            {
                instance = FindObjectOfType<PlayerDisplay>();
            }
            return instance;
        }
    }

    public void UpdateLivesImage(int newLives) {
        switch (newLives) {
            case 3:
                livesImage.sprite = lives3Sprite;
                break;
            case 2:
                livesImage.sprite = lives2Sprite;
                break;
            case 1:
                livesImage.sprite = lives1Sprite;
                break;
            case 0:
            default:
                livesImage.sprite = lives0Sprite;
                break;
        }
    }
}
