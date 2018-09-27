'use strict';

module.controller('MateriaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
    //listar
    $scope.lista = null;
//    $scope.id=3;
    
    $scope.listaCarrera=null;
    $scope.listaProfesor=null;
        
    $scope.datosMateria = {horario:[]};
    $scope.panelEditar = false;

    
   
    //guardar
    $scope.nuevo = function () {
        $scope.panelEditar = true;
        //$scope.datosFormulario = {horario:[]};
    };
    $scope.getMateria=function(){
        $http.get("./webresources/ServicioMateria",{})
            .then(function(response) {
                $scope.lista = response.data;
        }, function(){
                        alert("error");
        });
    }
    
     $scope.getCarrera=function(){
        $http.get("./webresources/ServicioCarrera",{})
            .then(function(response) {
                $scope.listaCarrera = response.data;
        }, function(){
                        alert("error");
        });
    }
     $scope.getProfesor=function(){
        $http.get("./webresources/ServicioProfesor",{})
            .then(function(response) {
                $scope.listaProfesor = response.data;
        }, function(){
                        alert("error");
        });
    }
    
    $scope.nuevoHorario= function(){
        $scope.datosHorario = {};
        $('#modalHorario').modal('show');
    }
    
    $scope.guardar = function () {
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        
        if (!$scope.datosMateria.id){
            $scope.datosMateria.id = $scope.id++;
            $scope.lista.push($scope.datosMateria);
        }
        $scope.panelEditar = false;
    };
    $scope.cancelar = function () {
        $scope.panelEditar = false;
        $scope.datosMateria = {};
    };

    //editar
    $scope.editar = function (data) {
        $scope.panelEditar = true;
        $scope.datosMateria = data;
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
   
    $scope.guardarHorario = function(){
         $http.post("./webresources/ServicioHorario",$scope.datosMateria.horario)
            .then(function(response) {
               $scope.getHorario(); 
        });
//        $scope.datosMateria.horario.push($scope.datosHorario);
//        $('#modalHorario').modal('hide');
    }
    

     $scope.getMateria();
     $scope.getProfesor();
      $scope.getCarrera();
}]);



