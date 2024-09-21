<?php

$books = [
    [
        'name' => 'The Daily Laws',
        'author' =>  'Robert Greene',
        'purchaseUrl' => 'https://rb.gy/72cpdi',
        'publishedYear' => '2021'
    ],   
    
    [
        'name' => 'The 48 Laws of Power',
        'author' =>  'Robert Greene',
        'purchaseUrl' => 'https://rb.gy/zl0b6q',
        'publishedYear' => '1998'
    ],  

    [
        'name' => 'The 33 Strategies of War',
        'author' =>  'Robert Greene',
        'purchaseUrl' => 'https://rb.gy/kfeqwq',
        'publishedYear' => '2006'
    ],

    [
        'name' => 'The Great Gatsby ',
        'author' =>  'F. Scott Fitzgerald',
        'purchaseUrl' => 'https://tinyurl.com/4k954sx5',
        'publishedYear' => '1922'
    ],

    [
        'name' => 'One Hundred Years of Solitude',
        'author' =>  'Gabriel García Márquez',
        'purchaseUrl' => 'https://tinyurl.com/mvmfjmym',
        'publishedYear' => '1967'
    ]
];

$filteredBooks = array_filter($books, function ($book) {
    return $book['publishedYear'] <=2000 && $book['author'] == 'Robert Greene';
});

include "index.view.php";






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

