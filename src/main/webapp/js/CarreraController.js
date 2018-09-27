'use strict';

//var listaCarreras=[{nombre:'Ingenieria de sistemas', facultad:{id:1,nombre:'ingenieria'}}]
var app=angular.module('cursoApp',[]);
module.controller('CarreraCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
  
    $scope.lista = null;
    $scope.listaFacultad=null;
    
    $scope.getCarrera=function(){
        $http.get("./webresources/ServicioCarrera",{})
            .then(function(response) {
                $scope.lista = response.data;
        }, function(){
                        alert("error");
        });
    }
    
     $scope.getFacultad=function(){
        $http.get("./webresources/ServicioFacultad",{})
            .then(function(response) {
                $scope.listaFacultad = response.data;
        }, function(){
                        alert("error");
        });
    }
    $scope.guardarCarrera=function(){
        $http.post("./webresources/ServicioCarrera",$scope.datosCarrera)
            .then(function(response) {
               $scope.getCarrera(); 
        });
    }
        
        //listar
//    $scope.lista = listaCarreras;
    $scope.datosCarrera = {};
    $scope.panelEditar = false;
    
//    $scope.listaFacultad=null;
    
    //guardar
    $scope.nuevo = function () {
        $scope.panelEditar = true;
        $scope.datosCarrera = {};
    };
    
    $scope.guardar = function () {
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        
        if (!$scope.datosCarrera.id){
            $scope.datosCarrera.id = $scope.id++;
            $scope.lista.push($scope.datosCarrera);
            
        }
        $scope.panelEditar = false;
    };
    $scope.cancelar = function () {
        $scope.panelEditar = false;
        $scope.datosCarrera = {};
    };

    //editar
    $scope.editar = function (data) {
        $scope.panelEditar = true;
        $scope.datosCarrera = data;
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
     $scope.getCarrera();
     $scope.getFacultad();
}]);
