We see that the image is first encoded with AES-ECB. The vulnerability with AES-ECB is that when it is used to encode 
images, one can easily see the original text. 

![ecb is bad](placeholder)

Therefore, we don't have to do any AES Cracking in this challenge. What does cause the randomness is in the python script,
which is fittingly deigned "Addition Block Chaining".

    blocks = [ct[i * BLOCK_SIZE:(i+1) * BLOCK_SIZE] for i in range(len(ct) / BLOCK_SIZE)]
    iv = os.urandom(16)
    blocks.insert(0, iv)
    
    for i in range(len(blocks) - 1):
        prev_blk = int(blocks[i].encode('hex'), 16)
        curr_blk = int(blocks[i+1].encode('hex'), 16)

        n_curr_blk = (prev_blk + curr_blk) % UMAX
        blocks[i+1] = to_bytes(n_curr_blk)

    ct_abc = "".join(blocks)
What the python does is generate 16 bytes, put the bytes at the beginning of the result, and then iterate over the image
for every 16 bits. Each resultant 16 bits is simply the addition of the last encoded block and then the current block in
the image, add them together, mod by 0xFFFFFFFFFFFFFFFF.

Use your favorite scripting language to do the opposite of this process.
