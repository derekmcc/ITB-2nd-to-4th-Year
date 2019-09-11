using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SlideBehaviour : StateMachineBehaviour {

    private Vector2 slideSize = new Vector2(1.8f, 2.4f);
    private Vector2 slideOffset = new Vector2(0f, -0.9f);

    private Vector2 size;
    private Vector2 offSet;

    private BoxCollider2D boxCollider;
    // OnStateEnter is called when a transition starts and the state machine starts to evaluate this state
    override public void OnStateEnter(Animator animator, AnimatorStateInfo stateInfo, int layerIndex) {
		Character.Instance.slide = true;

        if (boxCollider == null) {
            boxCollider = Character.Instance.GetComponent<BoxCollider2D>();
            size = boxCollider.size;
            offSet = boxCollider.offset;
        }
        boxCollider.size = slideSize;
        boxCollider.offset = slideOffset;
    }

	// OnStateUpdate is called on each Update frame between OnStateEnter and OnStateExit callbacks
	//override public void OnStateUpdate(Animator animator, AnimatorStateInfo stateInfo, int layerIndex) {
	//
	//}

	// OnStateExit is called when a transition ends and the state machine finishes evaluating this state
	override public void OnStateExit(Animator animator, AnimatorStateInfo stateInfo, int layerIndex) {
		Character.Instance.slide = false;
		animator.ResetTrigger ("Slide");
        boxCollider.size = size;
        boxCollider.offset = offSet;
	}

	// OnStateMove is called right after Animator.OnAnimatorMove(). Code that processes and affects root motion should be implemented here
	//override public void OnStateMove(Animator animator, AnimatorStateInfo stateInfo, int layerIndex) {
	//
	//}

	// OnStateIK is called right after Animator.OnAnimatorIK(). Code that sets up animation IK (inverse kinematics) should be implemented here.
	//override public void OnStateIK(Animator animator, AnimatorStateInfo stateInfo, int layerIndex) {
	//
	//}
}
