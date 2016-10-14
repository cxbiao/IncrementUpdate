

cmake_minimum_required(VERSION 3.4.1)
set(CMAKE_VERBOSE_MAKEFILE on)

include_directories(bzip2)

#自动查找目录中的源文件，并加入编译

aux_source_directory(${CMAKE_SOURCE_DIR}/bzip2 src_dir1)
set(SRC_LIST ${src_dir1} bsdiff.c )

add_executable( # Sets the name of the library.
             bsdiff
          

             # Provides a relative path to your source file(s).
             # Associated headers in the same location as their source
             # file are automatically included.
             ${SRC_LIST}
              )
