/* global module */

'use strict';
var app=angular.module('cursoApp',[]);

module.controller('ProfesorCtrl', ['$scope', '$filter', '$http', 
    function ($scope, $filter, $http) {
    //listar
    
    //$scope.profesores = null;
    $scope.lista = null;
    $scope.id=8;
    $scope.getProfesor=function(){
        $http.get("./webresources/ServicioProfesor",{})
            .then(function(response) {
                $scope.lista = response.data;
        }, function(){
                        alert("error");
        });
    }
     $scope.guardarProfesor=function(){
        $http.post("./webresources/ServicioProfesor",$scope.datosProfesor)
            .then(function(response) {
               $scope.getProfesor(); 
        });
    }
    $scope.editarProfesor=function(){
        $http.put("./webresources/ServicioProfesor/editarProfesor",$scope.datosProfesor)
            .then(function(response) {
               $scope.getProfesor(); 
        });
    }
    
       $scope.eliminarProfesor=function(){
        console.log("estamos borrando");
        $http.delete("./webresources/ServicioProfesor/eliminarProfesor",$scope.datosProfesor)
            .then(function(response) {
               $scope.getProfesor(); 
        });
    } 
    //LISTAR
    $scope.datosProfesor ={};
    $scope.panelEditar = false;   
    
        
    //guardar
    $scope.nuevo = function () {
        $scope.panelEditar = true;
        $scope.datosProfesor = {};
    };
    
    $scope.guardar = function () {
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        
        if (!$scope.datosProfesor.id){
            $scope.datosProfesor.id = $scope.id++;
            $scope.lista.push($scope.datosProfesor.id);
            $scope.guardarProfesor();
        }
        else{
            console.log("voy a editar");
            $scope.editarProfesor();
            
            //funcion al servicio de actualizar...
        }
        $scope.panelEditar = false;
    };
    $scope.cancelar = function () {
        $scope.panelEditar = false;
        $scope.datosProfesor = {};
    };

    //editar
    $scope.editar = function (data) {
        $scope.panelEditar = true;
        $scope.datosProfesor = data;
    };
    //eliminar
    $scope.eliminar = function (data){
        if (confirm('\xbfDesea elminar este registro?')) {    
            for(var i=0; i<$scope.lista.length; i++){
                if($scope.lista[i]==data){
                    $scope.lista.splice(i,1);
                    $scope.eliminarProfesor();
                    break;
                }
            }
        }
    };
    $scope.getProfesor();
}]);



