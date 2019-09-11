<?php

$user = \Itb\User::getOneByUsername($username);
?>
<h1><a href="index.php?action=profile">Back to Profile</a></h1>
<h1>Change Password</h1>

<form
    action="index.php?action=updateProfile"
    method="POST"
>
    <!-- ****** send ID, but don't let user see this ***** -->
    <input type="hidden" name="id" value="<?= $user->getId() ?>">
    <p>
        <label>Enter New Password:</label>
        <input type="password" name="password"">
    </p>

    <input type="submit" value="Update Password">

</form>
