#version 110

uniform sampler2D texture1; //Remember back to my first tutorial (if you read it). Samplers are data types used to access textures. //To use textures from your main program, this must be uniform. 

void main() {
    gl_FragColor = texture2D(texture1, gl_TexCoord[0].st); //And that is all we need.
    //gl_FragColor you already should know. texture2D is a built in function used to retrieve a particular texel from a sampler. It
    //takes a sampler2D and a vec2 argument. If your confused about the .st : remember you can access elements in a vector using s, t
    //p, q. But these can also be used to get more than one element at a time. So st gives a vec2 of the first and second elements.
    //It probably won't surprise you that similar samplers also exist for 1D and 3D textures. They are:
    //  Type: sampler1D  Function: texture1D(sampler1D, float)
    //  Type: sampler3D  Function: texture3D(sampler3D, vec3)
    // But there are a whole host of functions to achieve various texture sampling objectives such as projection and offsets. These I
    // have never used and will not go into. They are there if you want to research.
}