<?php

require_once __DIR__ . '/../vendor/autoload.php';

use Itb\User;

define('DB_HOST','localhost');
define('DB_USER', 'root');
define('DB_PASS', 'root');
define('DB_NAME', 'guardians');

$derek = new User();
$derek->setUsername('derek');
$derek->setPassword('mccarthy');
$derek->setImage('images/userProfilePics/user.ico');
$derek->setRole(1);

$john = new User();
$john->setUsername('john');
$john->setPassword('doe');
$john->setImage('images/userProfilePics/user.ico');
$john->setRole(1);

$admin = new User();
$admin->setUsername('admin');
$admin->setPassword('admin');
$admin->setImage('images/userProfilePics/user.ico');
$admin->setRole(2);

User::insert($derek);
User::insert($john);
User::insert($admin);

$users = User::getAll();
var_dump($users);







