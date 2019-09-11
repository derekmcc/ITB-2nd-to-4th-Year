using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RangedState : IEnemyState {

	private Enemy enemy;
	private float knifeTimer;
	private float knifeWait = 3f;
	private bool canThrow = true;

	#region IEnemyState implementation

	public void Execute () {
		ThrowKnife ();
		if (enemy.InMeleeRange) {
			enemy.ChangeState (new MeleState ());
		}
		else if (enemy.Target != null) {
			enemy.Movement ();
		} else {
			enemy.ChangeState (new IdleState ());
		}
	}

	public void Enter (Enemy enemy) {
		this.enemy = enemy;
	}

	public void Exit () {

	}

	public void OnTriggerEnter (Collider2D other) {

	}

	#endregion

	private void ThrowKnife(){
		knifeTimer += Time.deltaTime;
		if(knifeTimer >= knifeWait){
			canThrow = true;
			knifeTimer = 0;
		}

		if (canThrow){
			canThrow = false;
			enemy.MyAnimator.SetTrigger ("Throwing");
		}
	}
}
