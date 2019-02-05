/* global module */

'use strict';

var listaEstudiantes=[
//    {
//        nombre:'Lorena', apellido:'Espitia',
//        codigo:201410448,documento:1054094812,fechaNacimiento:"1996-08-31"},
//{
//        nombre:'Viviana', apellido:'Lizarazo',
//        codigo:201390348,documento:1049263534,fechaNacimiento:"1995-02-15"}
        ];

module.controller('EstudianteCtrl', ['$scope', '$filter', '$http', 
    function ($scope, $filter, $http) {
    //listar
 //   $scope.lista = listaEstudiantes;
    //$scope.datosFormulario = {};
    
    $scope.panelEditar = false; 
    $scope.listaMunicipio = null;
    $scope.lista = null;
 //   $scope.estudiantes = null;
    $scope.id=1;
    
        $scope.getMunicipio=function(){
        $http.get("./webresources/ServicioMunicipio",{})
            .then(function(response) {
                $scope.listaMunicipio = response.data;
        }, function(){
                        alert("error");
        });
    }
    $scope.getEstudiantes=function(){
        $http.get("./webresources/ServicioEstudiante",{})
            .then(function(response) {
                $scope.lista = response.data;
        }, function(){
                        alert("error");
        });
    }
    
    $scope.guardarEstudiante=function(){
        $http.post("./webresources/ServicioEstudiante",$scope.datosEstudiante)
            .then(function(response) {
               $scope.getEstudiantes(); 
        });
    }
    $scope.editarEstudiante=function(){
        $http.put("./webresources/ServicioEstudiante/editarEstudiante",$scope.datosEstudiante)
            .then(function(response) {
               $scope.getEstudiantes(); 
        });
    }
    
       $scope.eliminarEstudiante=function(){
        console.log("estamos borrando");
        $http.delete("./webresources/ServicioEstudiante/eliminarEstudiante",$scope.datosEstudiante)
            .then(function(response) {
               $scope.getEstudiantes(); 
        });
    } 
    //listar
    $scope.datosEstudiante = {};
        
    //guardar
    $scope.nuevo = function () {
        $scope.panelEditar = true;
        $scope.datosEstudiante = {};
    };
    
    $scope.guardar = function () {
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        
        if (!$scope.datosEstudiante.id){
            $scope.datosEstudiante.id = $scope.id++;
            $scope.lista.push($scope.datosEstudiante.id);
            $scope.guardarEstudiante();
        }
        else{
            console.log("voy a editar");
            $scope.editarEstudiante();
            
            //funcion al servicio de actualizar...
        }
        $scope.panelEditar = false;
    };
    $scope.cancelar = function () {
        $scope.panelEditar = false;
        $scope.datosEstudiante = {};
    };

    //editar
    $scope.editar = function (data) {
        $scope.panelEditar = true;
        $scope.datosEstudiante = data;
    };
    //eliminar
    $scope.eliminar = function (data){
        if (confirm('\xbfDesea elminar este registro?')) {    
            for(var i=0; i<$scope.lista.length; i++){
                if($scope.lista[i]==data){
                    $scope.lista.splice(i,1);
                    $scope.eliminarEstudiante();
                    break;
                }
            }
        }
    };
    $scope.getMunicipio();
    $scope.getEstudiantes();
}]);
