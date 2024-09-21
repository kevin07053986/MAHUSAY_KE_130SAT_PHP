<?php

include 'functions.php';

include 'Database.php';

// include 'router.php';

//connect to our MySQL database.
$config = include('config.php');

$db = new Database($config['database']);

$id = $_GET['id'];
$query = "select * from posts where id = ?";



$posts = $db->query($query, [$id])->fetch();

dd($posts);

// foreach ($posts as $post) {
//     echo "<li>" . $post['title'] . "</li>";
// }



// class Person 
// {
//     public $name;
//     public $age;

//     public function breathe()
//     {
//         echo $this->name . ' is breathing!';
//     }
// }

// $person = new Person ();

// $person->name = 'John Doe';
// $person->age = 25;

// $person->breathe();



/* $uri = $_SERVER['REQUEST_URI'];

 if($uri == '/') {

    include 'controllers/index.php';

} else if ($uri == '/about') {

    include 'controllers/about.php';

}else if($uri == '/contact') {

    include 'controllers/contact.php';

}else if ($uri == '/mission') {

    include 'controllers/mission.php';

}  */

// Create a prepared statement to fetch the post that has an id of 1. Then, experiment with calling fetch() instead of fetchAll(). How is the output different?

/* <?php

include 'functions.php';

// include 'router.php';

//connect to our MySQL database.

$dsn = "mysql:host=localhost;port=3306;dbname=myapp;user=root;password=imdbsys31;charset=utf8mb4";

$pdo = new PDO($dsn);

$statement = $pdo->prepare("select * from posts WHERE id = :id" );

$statement->bindValue(':id', 1, PDO::PARAM_INT);

$statement->execute();

$posts = $statement->fetch(PDO::FETCH_ASSOC);

echo "Using fetch():\n";
dd($posts); */