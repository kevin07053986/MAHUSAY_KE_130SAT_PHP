<?php

$heading = 'Home';

include 'functions.php';

/* if($_SERVER['REQUEST_URI'] == '/') {
    echo 'bg-gray-900 text-white';
} else {
    echo 'text-gray-300';
} */

// echo $_SERVER['REQUEST_URI'] == '/' ? 'bg-gray-900 text-white' : 'text-gray-300';

include "views/index.view.php";






/* //      <?php echo $message;?> 
//         $read = false; 

//         if ($read){ 
//             $message = "You have read $name by $author"; 
//         } else { 
//             $message = "Please finish reading $name by $author"; 
//        } 

//     <h1>  
//          <?= $message ?> 
//     </h1>    


// function filterByYear ($books, $year){
//     $filteredBooks = [];

//     foreach ($books as $book){
//         if ($book['publishedYear'] == $year){
//             $filteredBooks[] = $book;
//         }
//     }
    
//     return $filteredBooks;            
// }  


//  function filter ($items, $function)
//         {
//             $filteredItems = [];

//             foreach ($items as $item) {
//                 if ($function($item)) {
//                     $filteredItems[] = $item;
//                 }
//             }
            
//             return $filteredItems;            
//         }  */

