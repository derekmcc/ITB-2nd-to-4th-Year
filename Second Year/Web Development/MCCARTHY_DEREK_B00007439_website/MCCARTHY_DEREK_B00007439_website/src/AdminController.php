<?php
/**
 * Admin controller class
 */

namespace Itb;

/**
 * Class AdminController
 * @package Itb
 */
class AdminController
{
    /**
     * Variable to create an instance of a class
     * @var LoginController
     */
    private $loginController;

    /**
     * AdminController constructor.
     */
    public function __construct()
    {
        $this->loginController = new LoginController();
        $this->mainController = new MainController();
    }

    /**
     * Default home screen of admins
     */
    public function adminHomeAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        if ($isLoggedIn){
            $username = $this->loginController->usernameFromSession();
            $isAdmin = $this->loginController->isAdminUser($username);
            $backgroundColor = $this->mainController->getBackgroundColor();
            require_once __DIR__ . '/../templates/admin/profile.php';
        } else {
            $message = 'UNAUTHORIZED ACCESS';
            require_once __DIR__ . '/../templates/message.php';
        }
    }


    /**
     * Enable admins to edit products
     */
    public function adminCrudAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        if ($isLoggedIn){
            $username = $this->loginController->usernameFromSession();
            $isAdmin = $this->loginController->isAdminUser($username);
            $backgroundColor = $this->mainController->getBackgroundColor();
            require_once __DIR__ . '/../templates/admin/crud.php';
        } else {
            $message = 'UNAUTHORIZED ACCESS';
            require_once __DIR__ . '/../templates/message.php';
        }
    }




}