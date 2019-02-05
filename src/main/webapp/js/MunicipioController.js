'use strict';

//var listaMunicipios=
//        [
//    {id:1,nombre:'Tunja'}, {id:2,nombre:'Duitama'},{id:3,nombre:'Sogamoso'}
//    ];

var app=angular.module('cursoApp',[]);

module.controller('MunicipioCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
    
    $scope.lista = null;
    $scope.id=7;

        $scope.getMunicipio=function(){
        $http.get("./webresources/ServicioMunicipio",{})
            .then(function(response) {
                $scope.lista = response.data;
        }, function(){
                        alert("error");
        });
    }
    
    $scope.guardarMunicipio=function(){
        $http.post("./webresources/ServicioMunicipio",$scope.datosMunicipio)
            .then(function(response) {
               $scope.getMunicipio(); 
        });
    }
        
        $scope.editarMunicipio=function(){
        $http.put("./webresources/ServicioMunicipio/editarMunicipio",$scope.datosMunicipio)
            .then(function(response) {
       $scope.getMunicipio();
        });
    }  
        $scope.eliminarMunicipio=function(){
        console.log("estamos borrando");
        $http.delete("./webresources/ServicioMunicipio/eliminarMunicipio",$scope.datosMunicipio)
            .then(function(response) {
               $scope.getCarrera(); 
//       $scope.getFacultad();
        });
    } 
        //listar
    
    $scope.datosMunicipio = {};
    $scope.panelEditar = false;
    
    //guardar
    $scope.nuevo = function () {
        $scope.panelEditar = true;
        $scope.datosMunicipio = {};
    };
    
    $scope.guardar = function () {
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        
        if (!$scope.datosMunicipio.id){
            $scope.datosMunicipio.id = $scope.id++;
            $scope.lista.push($scope.datosMunicipio.id);
            $scope.guardarMunicipio();
        }else{
            $scope.editarMunicipio();
        }
        $scope.panelEditar = false;
    };
    $scope.cancelar = function () {
        $scope.panelEditar = false;
        $scope.datosMunicipio = {};
    };

    //editar
    $scope.editar = function (data) {
        $scope.panelEditar = true;
        $scope.datosMunicipio = data;
    };
    //eliminar
    $scope.eliminar = function (data){
        if (confirm('\xbfDesea elminar este registro?')) {    
            for(var i=0; i<$scope.lista.length; i++){
                if($scope.lista[i]==data){
                    $scope.lista.splice(i,1);
                    $scope.eliminarMunicipio();
                    break;
                }
            }
        }
    };
    
    $scope.getMunicipio();
}]);
