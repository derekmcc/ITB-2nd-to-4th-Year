using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MeleState : IEnemyState {

	private Enemy enemy;
	private float attackTimer;
	private float attackWait = 3f;
	private bool canAttack = true;
	#region IEnemyState implementation

	public void Execute () {
		Attack ();

		if (enemy.InThrowRange && !enemy.InMeleeRange) {
			enemy.ChangeState (new RangedState ());
		}
		else if(enemy.Target == null){
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
	private void Attack(){
		attackTimer += Time.deltaTime;
		if(attackTimer >= attackWait){
			canAttack = true;
			attackTimer = 0;
		}

		if (canAttack){
			canAttack = false;
			enemy.MyAnimator.SetTrigger ("Attack");
		}
	}

}
