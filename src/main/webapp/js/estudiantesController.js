/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app=angular.module('cursoApp',[]);

app.controller('estudiantesController', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
   
    $scope.estudiantes = null;
    
    $scope.getEstudiantes=function(){
        $http.get("./webresources/ServicioEstudiante",{})
            .then(function(response) {
                $scope.estudiantes = response.data;
        }, function(){
                        alert("error");
        });
    }
    
    $scope.guardarEstudiante=function(){
        $http.post("./webresources/ServicioEstudiante",$scope.nuevoEstudiante)
            .then(function(response) {
               $scope.getEstudiantes(); 
        });
    }
    
    $scope.guardar=function(){
        $scope.estudiantes.push($scope.nuevoEstudiante);
         $scope.formVisibility=false;
    };
    
    $scope.formVisibility=false;
    $scope.mostrarFormulario=function(){
        $scope.formVisibility=true;
        console.log($scope.formVisibility);
    };
    
    $scope.getEstudiantes();
}]);