'use strict';


module.controller('HorarioCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {
    //listar
   $scope.listaHorario = null;
$scope.id=4;
    $scope.getHorario=function(){
        $http.get("./webresources/ServicioHorario",{})
            .then(function(response) {
                $scope.listaHorario = response.data;
        }, function(){
                        alert("error");
        });
    }
    //esta clase no la usamos por eso llamamos los metodos dentro de mateeriacontroller
    $scope.guardarHorario=function(){
        $http.post("./webresources/ServicioHorario",$scope.datosHorario)
            .then(function(response) {
               $scope.getHorario(); 
        });
    }
       $scope.editarHorario=function(){
        $http.put("./webresources/ServicioHorario/editarHorario",$scope.datosHorario)
            .then(function(response) {
               $scope.getHorario();
       $scope.getFacultad();
        });
    }
    
       $scope.eliminarHorario=function(){
        console.log("estamos borrando");
        $http.delete("./webresources/ServicioHorario/eliminarHorario",$scope.datosHorario)
            .then(function(response) {
               $scope.getHorario(); 
//       $scope.getFacultad();
        });
    }  
    $scope.datosHorario = {};
    $scope.panelEditarHorario = false;
    
    //guardar
    $scope.nuevo = function () {
        $scope.panelEditarHorario = true;
        $scope.datosHorario = {};
    };
    
   

    $scope.guardarH = function () {     
        $scope.errores = {};
        var error = false;
        
        if (error)
            return;
        
        if (!$scope.datosHorario.id){
            console.log("IFF ");
            $scope.datosHorario.id = $scope.id++;
            $scope.lista.push($scope.datosHorario);
            $scope.guardarHorario();
        }else{
            $scope.editarHorario();
        }

       
        $('#modalHorario').modal('hide');
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
                    $scope.eliminarHorario();
                    break;
                }
            }
        }
    };
     $scope.getHorario();
}]);

