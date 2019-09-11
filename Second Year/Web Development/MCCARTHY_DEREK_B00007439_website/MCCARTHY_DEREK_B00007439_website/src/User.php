<?php
/**
 * Class for user object
 */

namespace Itb;

use Mattsmithdev\PdoCrud\DatabaseTable;
use Mattsmithdev\PdoCrud\DatabaseManager;

/**
 * Class User
 * @package Itb
 */
class User extends DatabaseTable
{
    /**
     * constant variable to check users role
     */
    const ROLE_USER = 1;

    /**
     * constant variable to check users role
     */
    const ROLE_ADMIN = 2;

    /**
     * users id of type int
     * @var
     */
    private $id;

    /**
     * username of type string
     * @var
     */
    private $username;

    /**
     * users password of type string
     * @var
     */
    private $password;

    /**
     * users role of type int
     * @var
     */
    private $role;

    /**
     * users image of type string
     * @var
     */
    private $image;

    /**
     * get id
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * set id
     * @param mixed $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * get username
     * @return mixed
     */
    public function getUsername()
    {
        return $this->username;
    }

    /**
     * set username
     * @param mixed $username
     */
    public function setUsername($username)
    {
        $this->username = $username;
    }

    /**
     * get password
     * @return mixed
     */
    public function getPassword()
    {
        return $this->password;
    }

    /**
     * set & hash password
     * @param mixed $password
     */
    public function setPassword($password)
    {
        $hashedPassword = password_hash($password, PASSWORD_DEFAULT);

       // $this->password = $password;
        $this->password  = $hashedPassword;
    }

    /**
     * get role
     * @return mixed
     */
    public function getRole()
    {
        return $this->role;
    }

    /**
     * set role
     * @param mixed $role
     */
    public function setRole($role)
    {
        $this->role = $role;
    }

    /**
     * get image
     * @return mixed
     */
    public function getImage()
    {
        return $this->image;
    }

    /**
     * set image
     * @param mixed $image
     */
    public function setImage($image)
    {
        $this->image = $image;
    }

    /**
     * check if the username & password are in the db
     * @param $usernmae
     * @param $password
     * @return bool
     */
    public static function canFindMatchingUsernameAndPassword($usernmae, $password)
    {
        $user = User::getOneByUsername($usernmae);

        if(null == $user){
            return false;
        }

        /**
         * @var $user User
         */
        $hashedPassword = $user->getPassword();
        $passwordWasVerified = password_verify($password, $hashedPassword);

        return $passwordWasVerified;
    }

    /**
     * get the details for the chosen user
     * @param $username
     * @return mixed|null
     */
    public static function getOneByUsername($username)
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        $sql = 'SELECT * FROM users WHERE username=:username';
        $statement = $connection->prepare($sql);
        $statement->bindParam(':username', $username, \PDO::PARAM_STR);
        $statement->setFetchMode(\PDO::FETCH_CLASS, __CLASS__);
        $statement->execute();

        if ($object = $statement->fetch()) {
            return $object;
        } else {
            return null;
        }
    }

    /**
     * add a new user
     * @param $username
     * @param $password
     * @return bool
     */
    public static function addUser($username, $password)
    {
        $register = new User();
        $register->setUsername($username);
        $register->setPassword($password);
        $register->setRole(1);
        $register->setImage('/images/userProfilePics/user.ico');
        self::insert($register);
        if(null == $register){
            return false;
        }
        return true;
    }

    /**
     * change the users image
     * @param $id
     * @param $image
     * @return bool
     */
    public function changeImage($id, $image)
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        $sql = "UPDATE users SET image = '/images/userProfilePics/$image' WHERE id=$id";

        $numRowsAffected = $connection->exec($sql);

        if($numRowsAffected > 0){
            $queryWasSuccessful = true;
        } else {
            $queryWasSuccessful = false;
        }

        return $queryWasSuccessful;// = true;
    }

    /**
     * check for the users role
     * @param $username
     * @return null|string
     */
    public static function checkRole($username)
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();
        //$this->getRole();
        $sql = 'SELECT role FROM users WHERE username=$username';
        $statement = $connection->prepare($sql);
        $statement->bindParam(':username', $username, \PDO::PARAM_STR);
        $statement->setFetchMode(\PDO::FETCH_CLASS, __CLASS__);
        $statement->execute();

        if ($object = $statement->fetch()) {
            return $sql;
        } else {
            return null;
       }

    }

    /**
     * change the users password
     * @param $id
     * @param $password
     * @return bool
     */
    public function changePassword($id, $password)
    {
        $db = new DatabaseManager();
        $connection = $db->getDbh();

        self::setPassword($password);
        $hashedPassword = $this->getPassword();
        $sql = "UPDATE users SET password = '$hashedPassword' WHERE id='$id'";

        $numRowsAffected = $connection->exec($sql);

        // can set Boolean variable in a single statement
        $queryWasSuccessful = ($numRowsAffected > 0);

        if($numRowsAffected > 0){
            $queryWasSuccessful = true;
        } else {
            $queryWasSuccessful = false;
        }

        return $queryWasSuccessful;
    }

}