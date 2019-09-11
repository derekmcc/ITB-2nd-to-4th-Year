<?php
require_once __DIR__ . '/../vendor/autoload.php';
session_start();

use Itb\MainController;
use Itb\AdminController;
use Itb\LoginController;

define('DB_HOST','localhost');
define('DB_USER', 'root');
define('DB_PASS', 'root');
define('DB_NAME', 'guardians');

// get action GET parameter (if it exists)
$action = filter_input(INPUT_GET, 'action', FILTER_SANITIZE_STRING);

$mainController = new MainController;
$adminController = new AdminController();
$loginController = new LoginController();

// based on value (if any) of 'action' decide which template to output
switch ($action){
    case 'adminCrud':
        $adminController->adminCrudAction();
        break;
    case 'adminHome':
        $adminController->adminHomeAction();
        break;
    case 'profile':
        $mainController->profileAction();
        break;
    case 'setBackgroundColorBlue':
        $mainController->changeBackgroundColor('#ccffff');
        break;
    case 'setBackgroundColorGreen':
        $mainController->changeBackgroundColor('#f2ffe6');
        break;
    case 'setBackgroundColorDefault':
        $mainController->changeBackgroundColor('#ffffff');
        break;
    case 'payConfirm':
        $mainController->payConfirmAction();
        break;
    case 'checkout':
        $mainController->checkoutAction();
        break;
    case 'delete':
        $mainController->deleteProductAction();
        break;
    case 'addToCart':
        $mainController->addToCart();
        break;
    case 'removeFromCart':
        $mainController->removeFromCart();
        break;
    case 'emptyCart':
        $mainController->forgetSession();
        break;
    case 'showUpdateProduct':
        $mainController->showUpdateProductAction();
        break;
    case 'showNewProduct':
        $mainController->showNewProductAction();
        break;
    case 'createProduct':
        $mainController->createProductAction();
        break;
    case 'updateProduct':
        $mainController->updateProductAction();
        break;
    case 'login':
        $mainController->loginAction();
        break;
    case 'logout':
        $loginController->logoutAction();
        break;
    case 'processLogin':
        $loginController->processLoginAction();
        break;
    case 'editProfile':
        $mainController->editProfileAction();
        break;
    case 'updateProfile':
        $mainController->updateProfileAction();
        break;
    case 'shop':
        $mainController->shopAction();
        break;
    case 'show':
        $mainController->showOneProductAction();
        break;
    case 'about':
        $mainController->aboutAction();
        break;
    case 'imageUpload':
        $mainController->uploadImageAction();
        break;
    case 'processRegister':
        $mainController->processRegisterAction();
        break;
    case 'sitemap':
        $mainController->sitemapAction();
        break;
    default:
        // default is home page ('index' action)
        $mainController->indexAction();
}

