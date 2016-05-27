//Angular controller.

var mainApp = angular.module("mainApp", []);

mainApp.controller('studentController', function($scope) {
   $scope.student = {
      firstName: "Balaji",
      lastName: "Kola",
      fullName: function() {
         var studentObject;
         studentObject = $scope.student;
         return studentObject.firstName + " " + studentObject.lastName;
      }
   };
});