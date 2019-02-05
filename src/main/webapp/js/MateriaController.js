'use strict';

module.controller('MateriaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
        //listar
        $scope.lista = null;
        $scope.listaHorario = null;
//        $scope.datosHorario = {};
        $scope.id = 5;
        $scope.listaCarrera = null;
        $scope.listaProfesor = null;

              
        $scope.getMateria = function () {
            $http.get("./webresources/ServicioMateria", {})
                    .then(function (response) {
                        $scope.lista = response.data;
                    }, function () {
                        alert("error");
                    });
        }

        $scope.getCarrera = function () {
            $http.get("./webresources/ServicioCarrera", {})
                    .then(function (response) {
                        $scope.listaCarrera = response.data;
                    }, function () {
                        alert("error");
                    });
        }
        $scope.getProfesor = function () {
            $http.get("./webresources/ServicioProfesor", {})
                    .then(function (response) {
                        $scope.listaProfesor = response.data;
                    }, function () {
                        alert("error");
                    });
        }

        $scope.guardarMateria=function(){
        $http.post("./webresources/ServicioMateria",$scope.datosMateria)
            .then(function(response) {
               $scope.getHorario();
               $scope.getMateria();
//       $scope.getFacultad();
        });
    }
        $scope.editarMateria=function(){
        $http.put("./webresources/ServicioMateria/editarMateria",$scope.datosMateria)
            .then(function(response) {
               $scope.getMateria();
       
        });
    }
    
       $scope.eliminarMateria=function(){
        console.log("estamos borrando");
        $http.delete("./webresources/ServicioMateria/eliminarMateria",$scope.datosMateria)
            .then(function(response) {
               $scope.getMateria; 
//       $scope.getFacultad();
        });
    } 
         $scope.datosMateria = {listaHorario: []};
        $scope.panelEditar = false;
          $scope.datosHorario = {};
        //nuevo horario
         $scope.nuevoHorario= function(){
                  $scope.getHorario();
      
        $('#modalHorario').modal('show');
    }
    //*****************
     $scope.getHorario=function(){
        $http.get("./webresources/ServicioHorario",{})
            .then(function(response) {
                $scope.listaHorario = response.data;
        }, function(){
                        alert("error");
        });
    }
    
    $scope.guardarHorario=function(){
        console.log('datos horario', $scope.datosHorario);
        $http.post("./webresources/ServicioHorario",$scope.datosHorario)
            .then(function(response) {  
                console.log("Ya llegue horario");
               $scope.getHorario(); 
        });
    }
    //**************
    
    $scope.guardarH = function() {
        console.log("hola");
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        //no me funciono :(
        console.log($scope.datosHorario);
         console.log($scope.listaHorario);
        
        if (!$scope.datosHorario.id){
           
            $scope.datosHorario.id = $scope.id++;
            $scope.listaHorario.push($scope.datosHorario);
            $scope.guardarHorario();
            $scope.getHorario();
        }else{
//            $scope.editarHorario();
        }
        $('#modalHorario').modal('hide');
    };
    
    
 
//guardar
        $scope.nuevo = function () {
            console.log("voy a brir el panel");
            $scope.panelEditar = true;
            $scope.datosMateria = {};
        };
        
        $scope.guardar = function () {
            $scope.errores = {};
            var error = false;

            if (error)
                return;

            if (!$scope.datosMateria.id) {
                $scope.datosMateria.id = $scope.id++;
                $scope.lista.push($scope.datosMateria.id);
            $scope.guardarMateria();
            }else{
                $scope.editarMateria();
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
             $scope.getHorario();
        };
        //eliminar
        $scope.eliminar = function (data) {
            if (confirm('\xbfDesea elminar este registro?')) {
                for (var i = 0; i < $scope.lista.length; i++) {
                    if ($scope.lista[i] == data) {
                        $scope.lista.splice(i, 1);
                        $scope.eliminarMateria();
                        break;
                    }
                }
            }
        };
//

//
        $scope.getMateria();
        $scope.getProfesor();
        $scope.getCarrera();
        $scope.getHorario();
    }]);



