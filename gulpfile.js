(function main() {

    var gulp        = require('gulp'),
        sass        = require('gulp-sass'),
        rename      = require('gulp-rename'),
        fs          = require('fs'),
        path        = require('path'),
        yaml        = require('js-yaml'),
        browserify  = require('browserify'),
        babelify    = require('babelify'),
        config      = yaml.safeLoad(fs.readFileSync('./maptalk.yml', 'utf8'));

    var compile = function(destPath, entryFile) {

        return browserify({ debug: true })
            .transform(babelify)
            .require(entryFile, { entry: true })
            .bundle()
            .on('error', function (model) { console.error(['Error:', model.message].join(' ')); })
            .pipe(fs.createWriteStream(destPath));

    };

    gulp.task('compile', function() {
        compile(config.js.build, config.js.src[0]);
    });

    gulp.task('sass', function () {
        gulp.src(config.sass.src[0])
            .pipe(sass.sync().on('error', sass.logError))
            .pipe(rename(path.basename(config.sass.build)))
            .pipe(gulp.dest(path.dirname(config.sass.build)));
    });

    gulp.task('build', ['compile', 'sass']);
    gulp.task('default', ['build']);
    gulp.task('watch', function watch() {
        gulp.watch(config.js.src, ['compile']);
        gulp.watch(config.sass.src, ['sass']);
    });

})();
