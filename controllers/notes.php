<?php

$config = include('config.php');

$db = new Database($config['database']);

$heading = 'My Notes';

$notes = $db->query('select * from notes where user_id = 1;')->get();

include "views/notes.view.php";