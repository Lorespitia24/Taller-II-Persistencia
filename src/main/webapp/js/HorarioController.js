'use strict';

var listaHorario=[
    //{dia:'Lunes', horaInicio:'2:00pm', horaFinal:'4:00pm'},
//    {dia:'Martes', horaInicio:'2:00pm', horaFinal:'4:00pm'}
];

module.controller('HorarioCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
    //listar
   $scope.listaHorario = null;
//    $scope.id=3;
    $scope.getHorario=function(){
        $http.get("./webresources/ServicioHorario",{})
            .then(function(response) {
                $scope.lista = response.data;
        }, function(){
                        alert("error");
        });
    }
    
    $scope.guardarHorario=function(){
        $http.post("./webresources/ServicioHorario",$scope.datosHorario)
            .then(function(response) {
               $scope.getHorario(); 
        });
    }
        
    $scope.datosHorario = {};
    $scope.panelEditarHorario = false;
    
    //guardar
    $scope.nuevo = function () {
        $scope.panelEditarHorario = true;
        $scope.datosHorario = {};
    };
    
    $scope.guardar = function () {
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        
        if (!$scope.datosHorario.id){
            $scope.datosHorario.id = $scope.id++;
            $scope.lista.push($scope.datosHorario);
        }
        $scope.panelEditarHorario = false;
    };
    $scope.cancelar = function () {
        $scope.panelEditar = false;
        $scope.datosHorario = {};
    };

    //editar
    $scope.editar = function (data) {
        $scope.panelEditarHorario = true;
        $scope.datosHorario = data;
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
     $scope.getHorario();
}]);

