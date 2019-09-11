<?php
require_once __DIR__ . '/../_head.php';
require_once __DIR__ . '/../_nav.php';
$user = \Itb\User::getOneByUsername($username);
?>
<section>
<!--h1><a href="index.php?action=shop">Back</a></h1-->
<h2><?= $user->getUsername() ?>'s Details</h2>
<br>
<br>
<dl>
    <dt><img src="<?= $user->getImage() ?>" alt="" width="183" height="226"></dt>
    <dt>ID:</dt>
    <dd><?= $user->getId() ?></dd>
    <dt>Username:</dt>
    <dd><?= $user->getUsername() ?></dd>
</dl>
    <form enctype="multipart/form-data" action="index.php?action=imageUpload" method="POST">
        <input type="hidden" name="id" value="<?= $user->getId() ?>">
        <input type="hidden" name="MAX_FILE_SIZE" value="1000000" />
        <h4>Change Profile image</h4> <br><input name="uploadedfile" type="file" /><br />
        <input type="submit" value="Upload File" />
    </form>

    <br>
    <br>
    <br>
    <h4>Change Background Colour</h4>
    <a href='index.php?action=setBackgroundColorBlue'>Blue</a>
    <br>
    <a href='index.php?action=setBackgroundColorGreen'>Green</a>
    <br>
    <a href='index.php?action=setBackgroundColorDefault'>Default</a>
    <br>
    <br>
    <h4>Change Your Password</h4>
    <a href="index.php?action=editProfile">Change Password</a>
</section>

<?php require_once __DIR__ . '/../_footer.php';

