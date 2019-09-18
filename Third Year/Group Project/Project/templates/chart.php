<?php
require_once __DIR__ . '/../templates/_head.php';
require_once __DIR__ . '/../templates/_nav.php';
$indexLinkStyle = isset($indexLinkStyle) ? $indexLinkStyle : 'nav-link';
$chartLinkStyle = isset($chartLinkStyle) ? $chartLinkStyle : 'nav-link active';
$contactLinkStyle = isset($contactLinkStyle) ? $contactLinkStyle : 'nav-link';
$artistLinkStyle = isset($artistLinkStyle) ? $artistLinkStyle : 'nav-link';
$albumLinkStyle = isset($albumLinkStyle) ? $albumLinkStyle : 'nav-link';
$profileLinkStyle = isset($profileLinkStyle) ? $profileLinkStyle : '';
$adminAlbumLinkStyle = isset($adminAlbumLinkStyle) ? $adminAlbumLinkStyle : 'nav-link';
$adminArtistLinkStyle = isset($adminArtistLinkStyle) ? $adminArtistLinkStyle : 'nav-link';
$adminSingleLinkStyle = isset($adminSingleLinkStyle) ? $adminSingleLinkStyle : 'nav-link';
$songLinkStyle = isset($songLinkStyle) ? $songLinkStyle : 'nav-link';
$image = \Itb\User::getUserImageByUserName($username);
$charts = \Itb\Chart::getAll();
?>
<br>
<div class="container">
<table class="table table-striped">
    <tr>
        <th>Rank</th>
        <th>Album</th>
        <th>Artist</th>
        <th>Weeks on Chart</th>
    </tr>
    <?php foreach($charts as $chart) {?>
        <tr>
            <td><b><?= $chart->getChartID()?></b></td>
            <td><a href="index.php?action=showAlbum&albumName=<?= $chart->getChartAlbum() ?>"><?= $chart->getChartAlbum() ?></a></td>
            <td><a href="index.php?action=show&artistName=<?= $chart->getChartArtist() ?>">
                    <?= $chart->getChartArtist() ?></a></td>
            <td><?= $chart->getChartWeeks() ?></td>
        </tr>
    <?php } ?>
</table>
<?
//php require_once __DIR__ . '/_footer.php'; ?>
</div>
<script>
    $(document).ready(function () {
        var links = $('.navbar ul li a');
        $.each(links, function (key, va) {
            if (va.href == document.URL) {
                $(this).addClass('active');
            }
        });
    });
    $('#myModal').modal({
        keyboard: false
    })
</script>