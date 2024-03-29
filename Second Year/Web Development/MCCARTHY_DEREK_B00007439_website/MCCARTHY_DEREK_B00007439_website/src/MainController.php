<?php
/**
 * main controller class
 */

namespace Itb;

use Mattsmithdev\PdoCrud\DatabaseManager;

require_once  __DIR__ . '/Product.php';

/**
 * Class MainController
 * @package Itb
 */
class MainController
{
    /**
     * MainController constructor.
     */
    public function __construct()
    {
        $this->loginController = new LoginController();
    }

    /**
     * Default home action
     */
    function indexAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        $username = $this->loginController->usernameFromSession();
        $isAdmin = $this->loginController->isAdminUser($username);
        $backgroundColor = $this->getBackgroundColor();

        $pageTitle = 'Home';
        $indexLinkStyle = 'current_page';
        require_once __DIR__ . '/../templates/index.php';
    }

    /**
     * Shop action
     */
    function shopAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        $username = $this->loginController->usernameFromSession();
        $isAdmin = $this->loginController->isAdminUser($username);
        $backgroundColor = $this->getBackgroundColor();

        $pageTitle = 'Shop';
        $shopLinkStyle = 'current_page';
        $shoppingCart = $this->getShoppingCart();

        $products = Product::getAll();
        require_once __DIR__ . '/../templates/shop.php';
    }

    /**
     * Login action
     */
    function loginAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        $username = $this->loginController->usernameFromSession();
        $isAdmin = $this->loginController->isAdminUser($username);
        $backgroundColor = $this->getBackgroundColor();


        $pageTitle = 'Login';
        $loginLinkStyle = 'current_page';
        require_once __DIR__ . '/../templates/login.php';
    }

    /**
     * Edit profile action
     */
    function editProfileAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        $username = $this->loginController->usernameFromSession();
        $isAdmin = $this->loginController->isAdminUser($username);
        $backgroundColor = $this->getBackgroundColor();
        $pageTitle = 'Edit Profile';
        $editProfileLinkStyle = 'current_page';
        require_once __DIR__ . '/../templates/changePassword.php';
    }

    /**
     * Sitemap action
     */
    function sitemapAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        $username = $this->loginController->usernameFromSession();
        $isAdmin = $this->loginController->isAdminUser($username);
        $backgroundColor = $this->getBackgroundColor();


        $pageTitle = 'Sitemap';
        $sitemapLinkStyle = 'current_page';
        require_once __DIR__ . '/../templates/sitemap.php';
    }

    /**
     * profile action
     */
    function profileAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        $username = $this->loginController->usernameFromSession();
        $isAdmin = $this->loginController->isAdminUser($username);
        $backgroundColor = $this->getBackgroundColor();


        $pageTitle = 'Profile';
        $profileLinkStyle = 'current_page';
        require_once __DIR__ . '/../templates/admin/profile.php';
    }

    /**
     * Admin CRUD action
     */
    function adminCrudAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        $username = $this->loginController->usernameFromSession();
        $isAdmin = $this->loginController->isAdminUser($username);
        $backgroundColor = $this->getBackgroundColor();
        $pageTitle = 'Edit Products';
        $adminCrudLinkStyle = 'current_page';
        require_once __DIR__ . '/../templates/admin/crud.php';
    }

    /**
     * Admin default home screen action
     */
    function adminHomeAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        $username = $this->loginController->usernameFromSession();
        $isAdmin = $this->loginController->isAdminUser($username);
        $backgroundColor = $this->getBackgroundColor();
        $pageTitle = 'Profile';
        $profileLinkStyle = 'current_page';
        require_once __DIR__ . '/../templates/admin/profile.php';
    }

    /**
     * Checkout action
     */
    public function checkoutAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        $username = $this->loginController->usernameFromSession();
        $isAdmin = $this->loginController->isAdminUser($username);
        $backgroundColor = $this->getBackgroundColor();
        $shoppingCart = $this->getShoppingCart();
        require_once __DIR__ . '/../templates/checkout.php';
    }

    /**
     * About action
     */
    public function aboutAction()
    {
        $isLoggedIn = $this->loginController->isLoggedInFromSession();
        $username = $this->loginController->usernameFromSession();
        $isAdmin = $this->loginController->isAdminUser($username);
        $backgroundColor = $this->getBackgroundColor();
        $pageTitle = 'About';
        $aboutLinkStyle = 'current_page';
        require_once __DIR__ . '/../templates/about.php';
    }

    /**
     * Confirm pay action
     */
    public function payConfirmAction()
    {
        $message = 'Order confirmed on '. date('l \t\h\e jS');
        require_once __DIR__ . '/../templates/message.php';
    }

    /**
     * Change colour function
     * @param $color
     */
    public function changeBackgroundColor($color) {
        $_SESSION['backgroundColor'] = $color;
        $this->profileAction();
    }

    /**
     * Get the details of 1 product action
     */
    function showOneProductAction()
    {

        $id = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_NUMBER_INT);
        $product = Product::getOneById($id);

        if(null == $product){
            $message = 'Sorry, no product with id = ' . $id . ' could be retrieved from the database';

            // output the detail of product in HTML table
            require_once __DIR__ . '/../templates/message.php';
        } else {
            // output the detail of product in HTML table
            require_once __DIR__ . '/../templates/productDetails.php';
        }
    }

    /**
     * Delete the chosen product action
     */
    function deleteProductAction()
    {

        $id = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_NUMBER_INT);
        $success = Product::deleteProduct($id);

        if($success){
            $message = 'Product with id = ' . $id . ' was deleted successfully';
        } else {
            $message = 'Sorry, product with id = ' . $id . ' could not be deleted';
        }

        require_once __DIR__ . '/../templates/productDeleted.php';
    }

    /**
     * Change the users password action
     */
    public function updateProfileAction()
    {
        $id = filter_input(INPUT_POST, 'id', FILTER_SANITIZE_NUMBER_INT);
        $password = filter_input(INPUT_POST, 'password', FILTER_SANITIZE_STRING);


        $success = new User();
        $success->changePassword($id, $password);
        if($success){
            $message = "Your Password has been changed";
        } else {
            $message = 'Change Password action canceled no changes took place';
        }

        $mainController = new MainController();
        $mainController->profileAction();
    }

    /**
     * Update product details action
     */
    function updateProductAction()
    {
        $id = filter_input(INPUT_POST, 'id', FILTER_SANITIZE_NUMBER_INT);
        $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);
        $description = filter_input(INPUT_POST, 'description', FILTER_SANITIZE_STRING);
        $price = filter_input(INPUT_POST, 'price', FILTER_SANITIZE_NUMBER_FLOAT, FILTER_FLAG_ALLOW_FRACTION);
        $quantity = filter_input(INPUT_POST, 'quantity', FILTER_SANITIZE_NUMBER_INT);
        $image = filter_input(INPUT_POST, 'image', FILTER_SANITIZE_STRING);

        $success = Product::updateProduct($id, $name, $description, $price, $quantity, $image);

        if($success){
            $message = "Product with ID = $id updated";
        } else {
            $message = 'Update action canceled no changes took place';
        }
        require_once __DIR__ . '/../templates/productDeleted.php';
    }

    /**
     * Show updated product action
     */
    function showUpdateProductAction()
    {
        $id = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_NUMBER_INT);
        $product = Product::getOneById($id);

        require_once __DIR__ . '/../templates/admin/updateProduct.php';
    }

    /**
     * Show new product action
     */
    function showNewProductAction()
    {
        require_once __DIR__ . '/../templates/newProduct.php';
    }

    /**
     * Create a product action
     */
    function createProductAction()
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);
        $description = filter_input(INPUT_POST, 'description', FILTER_SANITIZE_STRING);
        $price = filter_input(INPUT_POST, 'price', FILTER_SANITIZE_NUMBER_FLOAT, FILTER_FLAG_ALLOW_FRACTION);
        $quantity = filter_input(INPUT_POST, 'quantity', FILTER_SANITIZE_NUMBER_INT);
        $image= filter_input(INPUT_POST, 'image', FILTER_SANITIZE_STRING);

        $success = Product::createProduct($name, $description, $price, $quantity, $image);

        if($success){
            $id = $connection->lastInsertId();
            $message = "SUCCESS - new product with ID = $id created";
        } else {
            $message = 'sorry, there was a problem creating new product';
        }
        require_once __DIR__ . '/../templates/productDeleted.php';
    }

    /**
     * Add to cart function
     */
    public function addToCart()
    {
        // get the ID of product to add to cart
        $id = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_NUMBER_INT);

        // get the cart array
        $shoppingCart = $this->getShoppingCart();

        // default is a new cart tiem
        $cartItem = new CartItem($id);

        // if quantity found in cart array, then use this
        if(isset($shoppingCart[$id])){
            $cartItem = $shoppingCart[$id];
            $oldQuantity = $cartItem->getQuantity();

            // store old quantity + 1 as new quantity into cart array
            $newQuantity = $oldQuantity + 1;
            $cartItem->setQuantity($newQuantity);
        }

        // store item in cart array
        $shoppingCart[$id] = $cartItem;

        // store new  array into SESSION
        $_SESSION['shoppingCart'] = $shoppingCart;

        // redirect to the shop page
        $this->shopAction();
    }

    /**
     * Remove from cart function
     */
    public function removeFromCart()
    {
        // get the ID of product to add to cart
        $id = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_NUMBER_INT);

        // get the cart array
        $shoppingCart = $this->getShoppingCart();

        // remove entry for this ID
        unset($shoppingCart[$id]);

        // store new  array into SESSION
        $_SESSION['shoppingCart'] = $shoppingCart;

        // redirect to the shop page
        $this->shopAction();
    }

    /**
     * Get the shopping cart
     * @return array
     */
    public function getShoppingCart()
    {
        if (isset($_SESSION['shoppingCart'])){
            return $_SESSION['shoppingCart'];
        } else {
            return [];
        }
    }

    /**
     * Kill the shopping session
     */
    public function forgetSession()
    {
        $this->killSession();

        // redirect to shop
        $this->shopAction();
    }

    /**
     * Unset the shopping cart session
     */
    public function killSession()
    {
        unset($_SESSION["shoppingCart"]);
    }

    /**
     * get the background colour
     * @return string
     */
    public function getBackgroundColor()
    {
        if (isset($_SESSION['backgroundColor'])){
            return $_SESSION['backgroundColor'];
        } else {
            return 'white';
        }
    }

    /**
     * Upload image function
     */
    public function uploadImageAction()
    {
        $target_path = "../public/images/userProfilePics";
        $id = filter_input(INPUT_POST, 'id', FILTER_SANITIZE_NUMBER_INT);

        /* Add the original filename to our target path.
        Result is "uploads/filename.extension" */
        $target_path = $target_path . basename( $_FILES['uploadedfile']['name']);

        $target_path = "../public/images/userProfilePics/";

        $target_path = $target_path . basename( $_FILES['uploadedfile']['name']);

        if(move_uploaded_file($_FILES['uploadedfile']['tmp_name'], $target_path)) {
          //  $this->updateUserAction($id,$target_path);
            $image = new User();
           // $image->changeImage($id);
            $images = basename( $_FILES['uploadedfile']['name']);
            $image->changeImage($id, $images);

            $mainController = new MainController();
            $mainController->profileAction();

        } else{
            $message = "There was an error uploading the file, please try again!";
            require_once __DIR__ . '/../templates/message.php';
        }
    }

    /**
     * Add new user function
     */
    public function processRegisterAction()
    {

        $db = new DatabaseManager();
        $connection = $db->getDbh();

        $username = filter_input(INPUT_POST, 'username', FILTER_SANITIZE_STRING);
        $password = filter_input(INPUT_POST, 'password', FILTER_SANITIZE_STRING);

        $success = User::addUser($username, $password);

        if($success){
            $id = $connection->lastInsertId();
            $message = "SUCCESS - new account with ID = $id created press home to login";
            require_once __DIR__ . '/../templates/message.php';
        } else {
            $message = 'Sorry, there was a problem creating an account';
            require_once __DIR__ . '/../templates/message.php';
        }

    }

    /**
     * Update the user image
     * @param $id
     * @param $image
     */
    public function updateUserAction($id, $image)
    {
        $queryWasSuccessful = new User();
        $queryWasSuccessful->setImage($image);

        if($queryWasSuccessful){
            $message = "User with ID = $id updated";
        } else {
            $message = 'Update action canceled no changes took place';
        }

        require_once __DIR__ . '/../templates/message.php';
    }

}