using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class GameManager : MonoBehaviour {
    [SerializeField]
    private int timeForLevel = 180;
    [SerializeField]
    private Slider timerSlider;
    private CountdownTimer countdownTimer;
    
    void Start() {
        countdownTimer = GetComponent<CountdownTimer>();
        countdownTimer.ResetTimer(timeForLevel);  
    }

    void Update() {
        int secondsLeft = countdownTimer.GetSecondsRemaining();
        CheckGameOver(secondsLeft);
        UpdateTimerSlider();
    }

    private void CheckGameOver(int secondsLeft) {
        if (secondsLeft < 0) {
            Application.LoadLevel("scene1_GameOver");
        }
    }

    private void UpdateTimerSlider() {
        float proportionRemaining = countdownTimer.GetProportionTimeRemaining();
        timerSlider.value = proportionRemaining;
    }

}
