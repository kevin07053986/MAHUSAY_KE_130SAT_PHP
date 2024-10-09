<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Support\Arr;

class Job extends Model {
    protected $table = 'job_listings';

    protected $fillable = ['title', 'salary'];

}



// public static function all(): array
// {
//     return [
//         [
//             'id' => 1,
//             'title' => 'Director',
//             'salary' => 'Php 50,000'
//         ],
//         [
//             'id' => 2,
//             'title' => 'Programmer',
//             'salary' => 'Php 40,000'
//         ],
//         [
//             'id' => 3,
//             'title' => 'Teacher',
//             'salary' => 'Php 30,000'
//         ]
//         ];
// }

// public static function find(int $id): array
// {
//     $job = Arr::first(static::all(), fn($job) => $job['id'] == $id);
//     // Arr::first($jobs, function ($job) use ($id){
//     //     return $job['id'] == $id;
//     // });  

//     if (! $job){
//         abort (404);
//     }   
    
//     return $job;
// }    

