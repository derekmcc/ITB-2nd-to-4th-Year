<?php
$indexLinkStyle = isset($indexLinkStyle) ? $indexLinkStyle : '';
$shopLinkStyle = isset($shopLinkStyle) ? $shopLinkStyle : '';
$adminCrudLinkStyle = isset($adminCrudLinkStyle) ? $adminCrudLinkStyle : '';
$profileLinkStyle = isset($profileLinkStyle) ? $profileLinkStyle : '';
$sitemapLinkStyle = isset($sitemapLinkStyle) ? $sitemapLinkStyle : '';
$editProfileLinkStyle = isset($editProfileLinkStyle) ? $editProfileLinkStyle : '';
$aboutLinkStyle = isset($aboutLinkStyle) ? $aboutLinkStyle : '';
?>

<header class="index_header">
        <div id="loginSection">
        <?php
        if($isLoggedIn):
            ?>
            You are logged in as: <strong><?= $username ?></strong>
            <br>
            <a href="index.php?action=logout">(Logout)</a>
            <?php
        else:
            ?>
            <a href="index.php?action=login">Login</a>
            <?php
        endif;
        ?>
        </div>
    <nav><!--div id='css menu'-->
        <ul>
            <li><a href='index.php' class="<?= $indexLinkStyle ?>">Home</a></li>
            <li><a href="index.php?action=shop" class="<?= $shopLinkStyle ?>">Shop</a></li>
            <li><a href='index.php?action=sitemap' class="<?=$sitemapLinkStyle?>">Sitemap</a></li>
            <li><a href="index.php?action=about" class="<?=$aboutLinkStyle?>">About</a></li>
            <?php
            //----------------------------
            if($isLoggedIn):?>
            <li><a href='index.php?action=profile' class="<?= $profileLinkStyle ?>">Profile</a></li>
            <?php
            endif;
            //----------------------------
            ?>
            <?php
            //----------------------------
            if($isAdmin):
                require_once __DIR__ . '/admin/_links.php';
            endif;
            //----------------------------
            ?>
        </ul>
    </nav>
    <!-- end navigation -->
</header>