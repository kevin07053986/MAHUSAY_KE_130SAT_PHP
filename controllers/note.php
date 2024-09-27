<?php

$config = include('config.php');

$db = new Database($config['database']);

$heading = 'Note';

$note = $db->query('select * from notes where id = :id', ['id'=> $_GET['id']])->fetch();

include "views/note.view.php";