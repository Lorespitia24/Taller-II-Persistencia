/* global module */

'use strict';
var app=angular.module('cursoApp',[]);

//var listaProfesores=[
//    {
 //       nombre:'Andrea', apellido:'Vargas',
 //       documento:'1054094812'},
//{
//        nombre:'Julian', apellido:'Ramirez',
//       documento:'1049263534'}
//       ];

module.controller('ProfesorCtrl', ['$scope', '$filter', '$http', 
    function ($scope, $filter, $http) {
    //listar
    
    //$scope.profesores = null;
    $scope.lista = null;
    
    $scope.getProfesor=function(){
        $http.get("./webresources/ServicioProfesor",{})
            .then(function(response) {
                $scope.lista = response.data;
        }, function(){
                        alert("error");
        });
    }
     $scope.guardarProfesor=function(){
        $http.post("./webresources/ServicioProfesor",$scope.datosCarrera)
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
            $scope.lista.push($scope.datosProfesor);
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
                    break;
                }
            }
        }
    };
    $scope.getProfesor();
}]);



