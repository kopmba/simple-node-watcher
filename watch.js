/*
This file is a helper to watch code for changes and debug when errors existed
from any compiler. The console log the error in output as helper to fix the
existing bug from project.
*/ 

var fs = require('fs');
var { spawn } = require('child_process');

const execLang = process.argv[2];
const runningFileFirstParam = process.argv[3];
const runningFileSecondParam = process.argv[4];

console.debug("Debug your project " + execLang + " by watching your files/directory changing with code errors.");

fs.watch(process.cwd(), { encoding: 'utf8' }, (eventType, filename) => {
  if (filename) {
    console.log(filename);
    const cmd = spawn(execLang, [runningFileFirstParam, runningFileSecondParam]);
    cmd.stdout.on('data', (data) => {
		console.log(`cmd stdout: ${data}`);
    });

    cmd.stderr.on('data', (data) => {
       console.log(`cmd stderr: ${data}`);
    });

    cmd.on('close', (code) => {
       if (code !== 0) {
    	  console.log(`cmd process exited with code ${code}`);
       }

    });
  }
});
