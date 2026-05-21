cmake_minimum_required(VERSION 3.6)
function(get_nlohmann_json)
    message(STATUS "Using pre-supplied nlohmann/json...")
    add_subdirectory("${CMAKE_BINARY_DIR}/third-party/json"
                     "${CMAKE_BINARY_DIR}/third-party/json/build")
    message(STATUS "nlohmann/json - Done")
endfunction()
get_nlohmann_json()
