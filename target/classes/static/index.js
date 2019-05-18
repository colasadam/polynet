angular.module('PolyNet', []).controller('mainController',function($scope,$http){

    $http({
        method: 'GET',
        url: '/feed'
    }).then(function successCallback(response) {
        console.log("Sucess ?");
        $scope.laliste = response.data;
        console.log(response);
    }, function errorCallback(response) {
        console.error('Error get : ' + response.error);
    });


    $scope.createStory = function(){
        $http({
            method: 'POST',
            url: '/story/',
            data : $scope.Story.text
        }).then(function successCallback(response) {
            $scope.Story = {};
            $scope.laliste = response.data;
        }, function errorCallback(response) {
            console.error(response.error);
        });

    };

    $scope.createCom = function(id_story,com){

        $http({
            method: 'POST',
            url: '/com/' + id_story,
            data: com

        }).then(function successCallback(response) {
            $scope.Com = {};
            $scope.laliste = response.data;
        }, function errorCallback(response) {
            console.error(response.error);
        });
    };

    $scope.delete_story = function(id_story){
        $http({
            method:'POST',
            url:'/delete/',
            data :id_story
        }).then(function successCallback(response) {
            $scope.laliste=response.data;
        },function errorCallback(response){
            console.error(response.error)
        })
    };



});

