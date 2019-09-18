<?php /*
if (isset($_POST['search']) || !empty($_POST['search'])) {
    $search = $_POST['search'];
    echo  $search;
}
else{
    header("Location:404.php");
}*/
?>
<?php

require_once __DIR__ . '/_head.php';
require_once __DIR__ . '/_nav.php';
$album = Itb\Album::getOneByAlbum($message);
?>

<br>
<h4>RELEASE DETAILS</h4>
<img src="<?= $album->getAlbumImage() ?>" width="240" height="240">
<iframe width="560" height="315" align="right" src="<?= $album->getAlbumVideo()?>" frameborder="2" allowfullscreen></iframe>


    <br>
    <b>Album: </b><?= $album->getAlbumName() ?>
    <br>
    <b>Released: </b><?= $album->getAlbumRelease() ?></p>