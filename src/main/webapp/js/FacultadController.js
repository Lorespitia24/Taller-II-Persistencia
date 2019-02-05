'use strict';

//var listaFacultades=[{id:1,nombre:'ingenieria'}, {id:2,nombre:'educación'},{id:3,nombre:'musica'}];

module.controller('FacultadCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
    //listar
    $scope.lista = null;
    $scope.id=3;
        $scope.datosFacultad = {};
    $scope.panelEditar = false;
    
    $scope.getFacultad=function(){
        console.log("casito guardo");
        $http.get("./webresources/ServicioFacultad/traerFacultad",{})
            .then(function(response) {
                $scope.lista = response.data;
        }, function(){
                        alert("error");
        });
    }
    
    $scope.guardarFacultad=function(){
        console.log($scope.datosFacultad);
        $http.post("./webresources/ServicioFacultad",$scope.datosFacultad)
            .then(function(response) {
               $scope.getFacultad(); 
        });
    }
    
    $scope.editarFacultad=function(){
        $http.put("./webresources/ServicioFacultad/editarFacultad",$scope.datosFacultad)
            .then(function(response) {
               $scope.getFacultad(); 
        });
    }
    
       $scope.eliminarFacultad=function(){
        console.log("estamos borrando");
        $http.delete("./webresources/ServicioFacultad/eliminarFacultad",$scope.datosFacultad)
            .then(function(response) {
               $scope.getFacultad(); 
        });
    } 

    
    //guardar
    $scope.nuevo = function () {
        $scope.panelEditar = true;
        $scope.datosFacultad = {};
    };
    
    $scope.guardar = function () {
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        
        if (!$scope.datosFacultad.id){
            $scope.datosFacultad.id = $scope.id++;
            $scope.lista.push($scope.datosFacultad.id);
            $scope.guardarFacultad();
        }
        else{
            console.log("voy a editar");
            $scope.editarFacultad();
            
            //funcion al servicio de actualizar...
        }
        $scope.panelEditar = false;
    };
    $scope.cancelar = function () {
        $scope.panelEditar = false;
        $scope.datosFacultad = {};
    };

    //editar
    $scope.editar = function (data) {
        $scope.panelEditar = true;
        $scope.datosFacultad = data;
    };
    //eliminar
    $scope.eliminar = function (data){
        if (confirm('\xbfDesea elminar este registro?')) {    
            for(var i=0; i<$scope.lista.length; i++){
                if($scope.lista[i]===data){
                    $scope.lista.splice(i,1);
                    $scope.eliminarFacultad();
                    break;
                }
            }
        }
    };
     $scope.getFacultad();
}]);
