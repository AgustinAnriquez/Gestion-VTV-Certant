var app = angular.module('myApp', []);
//EL CONTROLADOR OBTIENE LOS DATOS DE UNA URL
app.controller('ControladorAutomoviles', function($scope, $http) {
    $http.get("http://localhost:8080/listaAutomoviles/listaMarcaAutomoviles").then(function(response) {
        $scope.datos = response.data;
        $scope.marca="";
        $Scope.modelo="";
        $Scope.version="";
    });
});