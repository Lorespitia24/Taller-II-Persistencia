'use strict';

var listaMaterias=[
//    {
//        nombre:'Software',credito:2}, {
//        nombre:'Software II',credito:2
//    }
];
var app=angular.module('cursoApp',[]);
module.controller('MatriculaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
    //listar
   $scope.lista = null;
   $scope.listaEstudiantes=null;
    $scope.listaMaterias=null;
//    $scope.id=3;
    $scope.getMatricula=function(){
        $http.get("./webresources/ServicioMatricula",{})
            .then(function(response) {
                $scope.lista = response.data;
        }, function(){
                        alert("error");
        });
    }
      $scope.getMateria=function(){
        $http.get("./webresources/ServicioMateria",{})
            .then(function(response) {
                $scope.listaMaterias = response.data;
        }, function(){
                        alert("error");
        });
    }
    

     $scope.getEstudiante=function(){
        $http.get("./webresources/ServicioEstudiante",{})
            .then(function(response) {
                $scope.listaEstudiantes = response.data;
        }, function(){
                        alert("error");
        });
    }
    
    $scope.guardarMatricula=function(){
        $http.post("./webresources/ServicioMatricula",$scope.datosMatricula)
            .then(function(response) {
               $scope.getMateria(); 
        });
    }
        
    $scope.datosMatricula = {};
    $scope.panelEditar = false;
    
    //guardar
    $scope.nuevo = function () {
        $scope.panelEditar = true;
        $scope.datosMatricula = {};
    };
    
    $scope.guardar = function () {
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        
        if (!$scope.datosMatricula.id){
            $scope.datosMatricula.id = $scope.id++;
            $scope.lista.push($scope.datosMatricula);
        }
        $scope.panelEditar = false;
    };
    $scope.cancelar = function () {
        $scope.panelEditar = false;
        $scope.datosMatricula = {};
    };

    //editar
    $scope.editar = function (data) {
        $scope.panelEditar = true;
        $scope.datosMatricula = data;
    };
    //eliminar
    $scope.eliminar = function (data){
        if (confirm('\xbfDesea elminar este registro?')) {    
            for(var i=0; i<$scope.lista.length; i++){
                if($scope.lista[i]==data){
                    $scope.lista.splice(i,1);
                    break;
                }
            }
        }
    };
     $scope.getEstudiante();
        $scope.getMateria();
        $scope.getMatricula();
 
}]);
