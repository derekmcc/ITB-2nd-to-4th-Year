<?php require_once __DIR__ . '/../templates/_head.php'; ?>
<?php require_once __DIR__ . '/../templates/_nav.php'; ?>
<?php $albums = \Itb\Album::getAll()?>
<?php $counter = 1;$count=0;
$albumArray = array();?>
<br>
<div class="container">

    <h1 class="display-4">Shop By Albums</h1>
    <br>
    <div class="row mx-auto my-auto">
        <div id="recipeCarousel" class="carousel slide w-100" data-ride="carousel">
            <div class="carousel-inner" role="listbox">
                <?php
                foreach($albums as $album) {
                    $count++;
                }
                for ($i=0;$i<10;$i++){
                    $albumArray[] =  \Itb\Album::getAlbumByAlbumID(rand($i,$count));
                }?>
                <?php $albu = \Itb\Album::getAlbumByAlbumID(rand(0,$count));?>
                <div class="carousel-item active">
                    <img class="d-block col-4 img-fluid" src="<?= $albu->getAlbumImage()?>">
                </div>
                <?php foreach($albumArray as $album) { ?>
                    <div class="carousel-item">
                        <a href="index.php?action=showAlbum&albumName=<?= $album->getAlbumName() ?>"><img class="d-block col-4 img-fluid" src="<?= $album->getAlbumImage()?>"></a>
                    </div>
                <?php }?>
            </div>
            <a class="carousel-control-prev" href="#recipeCarousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#recipeCarousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</div>

<fieldset class="rating">
    <input type="radio"
           value="5"
    />
    <label title="Rocks!" (click)='onClick(5)'>5 stars</label>

    <input type="radio"
           value="4"
    />
    <label title="Pretty good" (click)='onClick(4)'>4 stars</label>

    <input type="radio"
           value="3"
    />
    <label title="Meh" (click)='onClick(3)'>3 stars</label>

    <input type="radio"
           value="2"
    />
    <label title="Kinda bad" (click)='onClick(2)'>2 stars</label>

    <input type="radio"
           value="1"
    />
    <label title="Sucks big time" (click)='onClick(1)'>1 star</label>
</fieldset>
<style>
    /*.carousel-control-prev-icon {margin-left: 50px; color: black;}

    /*.carousel-control-next-icon {margin-right: 80px; color: black;}

    /* Set black background color, white text and some padding */
    footer {
        background-color: #555;
        color: white;
        padding: 15px;
    }
</style>
<style>
    @import url('https://fonts.googleapis.com/css?family=Roboto:300');
</style>
<script>
    $('#recipeCarousel').carousel({
        interval: 10000
    })

    $('.carousel .carousel-item').each(function(){
        var next = $(this).next();
        if (!next.length) {
            next = $(this).siblings(':first');
        }
        next.children(':first-child').clone().appendTo($(this));

        if (next.next().length>0) {
            next.next().children(':first-child').clone().appendTo($(this));
        }
        else {
            $(this).siblings(':first').children(':first-child').clone().appendTo($(this));
        }
    });

</script>
<style>
    .img-fluid {
        max-width: 100%;
        height: auto;
    }
    .carousel-inner .carousel-item-right.active,
    .carousel-inner .carousel-item-next {
        transform: translateX(33.33%);
    }

    .carousel-inner .carousel-item-left.active,
    .carousel-inner .carousel-item-prev {
        transform: translateX(-33.33%)
    }

    .carousel-inner .carousel-item-right,
    .carousel-inner .carousel-item-left{
        transform: translateX(0);
    }
</style>
<?php require_once __DIR__ . '/../templates/_footer.php'; ?>
