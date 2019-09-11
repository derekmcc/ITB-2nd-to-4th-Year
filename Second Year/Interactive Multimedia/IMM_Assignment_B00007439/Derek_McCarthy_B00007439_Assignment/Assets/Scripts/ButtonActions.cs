using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ButtonActions : MonoBehaviour {

	public void BUTTON_LOAD_SCENE0_WELCOME() {
#pragma warning disable CS0618 // Type or member is obsolete
        Application.LoadLevel("scene0_Welcome");
#pragma warning restore CS0618 // Type or member is obsolete
    }

    public void BUTTON_LOAD_SCENE_LEVEL1_PLAYING() {
#pragma warning disable CS0618 // Type or member is obsolete
        Application.LoadLevel("scene2_Level1Playing");
#pragma warning restore CS0618 // Type or member is obsolete
    }

}
