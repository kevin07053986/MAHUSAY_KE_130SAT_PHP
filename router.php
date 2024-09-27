<?php

$routes = include('routes.php');

function routeToController($uri, $routes){
    if (array_key_exists($uri, $routes)) {
        include $routes[$uri];
    } else {
        abort();
    }
}

function abort($code = 404){
    http_response_code($code);

    include "views/{$code}.php";

    die();
}

$uri =parse_url($_SERVER['REQUEST_URI'])['path'];

routeToController($uri, $routes);