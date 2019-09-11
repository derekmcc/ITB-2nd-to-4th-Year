<?php
$user = \Itb\User::getOneByUsername($username);
require_once __DIR__ . '/_head.php';
require_once __DIR__ . '/_nav.php';
?>
<h1>Successful login</h1>
<p>
Well done <?= $username ?>, you have sucessfully logged in to the system.
</p>
<p><?= $user->getId()?></p>