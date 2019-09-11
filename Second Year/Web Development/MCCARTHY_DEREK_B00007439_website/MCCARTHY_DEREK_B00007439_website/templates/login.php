<?php

require_once __DIR__ . '/../templates/_head.php';
require_once __DIR__ . '/_nav.php';
?>
<section class="split_forms">
<section>
    <form action="index.php?action=processLogin" method="post">
        <h2>Existent Member</h2>
        <br>
        <br>
        <h3>Login</h3>
        <p>
            Username:
            <br>
            <input type="text" name="username">
            <br>
            <br>
            Password:
            <br>
            <input type="password" name="password">
        </p>

        <p>
            <br>
            <input type="submit" value="Login">
        </p>
    </form>
    <br>
    <br>
    <br>
    <br>
    <br>
    <!--span><php print $error;?></span-->
</section>
    <section>
        <form action="index.php?action=processRegister" method="post">
            <h2>Register</h2>
            <br>
            <br>
            <h3>Create an Account</h3>
            <p>
                Username:
                <br>
                <input type="text" name="username">
                <br>
                <br>
                Password:
                <br>
                <input type="password" name="password">
            </p>

            <p>
                <input type="submit" value="Register">
            </p>
        </form>
    </section>
</section>
<?php require_once __DIR__ . '/../templates/_footer.php'; ?>
